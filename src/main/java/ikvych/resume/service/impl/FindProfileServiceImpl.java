package ikvych.resume.service.impl;

import ikvych.resume.entity.Profile;
import ikvych.resume.exception.NoSuchEntityException;
import ikvych.resume.repository.storage.ProfileRepository;
import ikvych.resume.repository.search.ProfileSearchRepository;
import ikvych.resume.service.FindProfileService;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindProfileServiceImpl implements FindProfileService {
    private Logger LOGGER = LoggerFactory.getLogger(FindProfileService.class);

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileSearchRepository profileSearchRepository;

    @Override
    public Profile findProfileById(Long profileId) {
        return profileRepository.findById(profileId).orElseThrow(() -> {
            String msg = String.format("Can't find profile with id: %s", profileId);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
    }

    @Override
    public Profile findProfileByUid(String uid) {
        return profileRepository.findByUid(uid).orElseThrow(() -> {
            String msg = String.format("Can't find profile with uid: %s", uid);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
    }

    @Override
    public Page<Profile> findAll(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Iterable<Profile> findAllForIndexing() {
        Iterable<Profile> all = profileRepository.findAll();
/*        for(Profile p : all) {
            p.getSkills().size();
            p.getCertificates().size();
            p.getLanguages().size();
            p.getPracticals().size();
            p.getCourses().size();
        }*/
        return all;
    }

    @Override
    public Page<Profile> findAllBySearchQuery(String query, Pageable pageable) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(query)
                        .field("objective")
                        .field("summary")
                        .field("firstName")
                        .field("lastName")
/*                        .field("info")*/
/*                        .field("certificates.name")
                        .field("languages.name")
                        .field("practics.company")
                        .field("practics.position")
                        .field("practics.responsibilities")
                        .field("skills.value")
                        .field("courses.name")
                        .field("courses.school")*/
                        .type(MultiMatchQueryBuilder.Type.PHRASE)
                        .fuzziness(Fuzziness.ZERO)
                        .operator(Operator.AND))
                .withSort(SortBuilders.fieldSort("id").order(SortOrder.DESC))
                .build();
        searchQuery.setPageable(pageable);
        Page<Profile> profiles = profileSearchRepository.search(searchQuery);
        return profiles;
    }

}
