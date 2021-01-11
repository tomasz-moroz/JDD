package pl.jjd.jjd.reposiotry;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.entity.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
