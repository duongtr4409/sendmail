package com.duongnv30.sendmaildemo.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataMailDTO {
    private String to;
    private String subject;
    private String content;
    private Map<String, Object> props;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Map<String, Object> getProps() {
		return props;
	}
	public void setProps(Map<String, Object> props) {
		this.props = props;
	}
	public DataMailDTO(String to, String subject, String content, Map<String, Object> props) {
		super();
		this.to = to;
		this.subject = subject;
		this.content = content;
		this.props = props;
	}
	public DataMailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
} 