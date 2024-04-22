package com.mokcoding.ex02.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor // 생성자
@AllArgsConstructor // 매개변수 // 근데 사용안하는게
@Getter // get
@Setter // set
@ToString //toString
public class BoardVO {
	private int boardId; //BOARD_ID
	private String boardTitle; // BOARD_TITLE
	private String boardContent; // BOARD_TITLE
	private String memberId;
	private Date boardDateCreated;
}
