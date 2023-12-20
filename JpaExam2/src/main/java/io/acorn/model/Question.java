package io.acorn.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
/**
 * 질문 게시판 Table 생성
 */
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(length = 200) // varchar2(200) 이랑 같은 의미
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	// 이렇게 해주면 question.getAnswerList() 호출해서 쓸 수 있다
	@OneToMany(mappedBy = "question", cascade=CascadeType.REMOVE)
	private List<Answer> answerList;
}
