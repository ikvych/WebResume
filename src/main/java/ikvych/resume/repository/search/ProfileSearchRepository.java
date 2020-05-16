package ikvych.resume.repository.search;

import ikvych.resume.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

public interface ProfileSearchRepository extends ElasticsearchRepository<Profile, Long> {

	Page<Profile> findByObjectiveLikeOrSummaryLike(
			String objective, String summary, Pageable pageable);
	
}
