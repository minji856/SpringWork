package io.acorn;

import lombok.Data;

@Data
public class MailDto {
	private String toAddress;
	private String title;
	private String content;
}
