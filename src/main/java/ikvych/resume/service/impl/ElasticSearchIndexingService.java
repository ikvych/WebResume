package ikvych.resume.service.impl;

import ikvych.resume.entity.Profile;
import ikvych.resume.repository.search.ProfileSearchRepository;
import ikvych.resume.service.FindProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ElasticSearchIndexingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchIndexingService.class);

/*    @Value("index.all.during.startup")*/
    private boolean indexingAllDuringStartUp = true;

    @Autowired
    private FindProfileService findProfileService;

    @Autowired
    private ProfileSearchRepository profileSearchRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @PostConstruct
    public void indexingAll() {
        if (indexingAllDuringStartUp) {
            LOGGER.info("Detected index all command");
            LOGGER.info("Clear old index");
            elasticsearchOperations.deleteIndex(Profile.class);
            LOGGER.info("Start index of profiles");
            for (Profile profile : findProfileService.findAllForIndexing()) {
                profileSearchRepository.save(profile);
                LOGGER.info("Successful indexing of profile: " + profile.getUid());
            }
            LOGGER.info("Finish index of profiles");
        }
        else{
            LOGGER.info("indexAllDuringStartup is disabled");
        }
    }
}
