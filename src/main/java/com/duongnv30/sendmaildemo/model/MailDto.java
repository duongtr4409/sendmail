package com.duongnv30.sendmaildemo.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MailDto {

	private String emailAddressFrom;
	private List<String> emailAddressTo = new ArrayList<>();
	private List<String> emailAddressCC = new ArrayList<>();
	private List<String> emailAddressBCC = new ArrayList<>();
	private String templateName;
	private String subject;
	private String content;
	private List<File> attachmentFile = new ArrayList<>();
	private Map<String, Object> props;

	public String getEmailAddressFrom() {
		return emailAddressFrom;
	}

	public void setEmailAddressFrom(String emailAddressSend) {
		this.emailAddressFrom = emailAddressSend;
	}

	public List<String> getEmailAddressTo() {
		return emailAddressTo;
	}

	public void setEmailAddressTo(List<String> emailAddressTo) {
		this.emailAddressTo = emailAddressTo;
	}

	public List<String> getEmailAddressCC() {
		return emailAddressCC;
	}

	public void setEmailAddressCC(List<String> emailAddressCC) {
		this.emailAddressCC = emailAddressCC;
	}

	public List<String> getEmailAddressBCC() {
		return emailAddressBCC;
	}

	public void setEmailAddressBCC(List<String> emailAddressBCC) {
		this.emailAddressBCC = emailAddressBCC;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
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

	public List<File> getAttachmentFile() {
		return attachmentFile;
	}

	public void setAttachmentFile(List<File> attachmentFile) {
		this.attachmentFile = attachmentFile;
	}

	public Map<String, Object> getProps() {
		return props;
	}

	public void setProps(Map<String, Object> props) {
		this.props = props;
	}

	public MailDto(String emailAddressSend, List<String> emailAddressTo, List<String> emailAddressCC,
			List<String> emailAddressBCC, String templateName, String subject, String content,
			List<File> attachmentFile) {
		super();
		this.emailAddressFrom = emailAddressSend;
		this.emailAddressTo = emailAddressTo;
		this.emailAddressCC = emailAddressCC;
		this.emailAddressBCC = emailAddressBCC;
		this.templateName = templateName;
		this.subject = subject;
		this.content = content;
		this.attachmentFile = attachmentFile;
	}

	public MailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MailDto [emailAddressSend=" + emailAddressFrom + ", emailAddressTo=" + emailAddressTo
				+ ", emailAddressCC=" + emailAddressCC + ", emailAddressBCC=" + emailAddressBCC + ", templateName="
				+ templateName + ", subject=" + subject + ", content=" + content + ", attachmentFile=" + attachmentFile
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attachmentFile == null) ? 0 : attachmentFile.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((emailAddressBCC == null) ? 0 : emailAddressBCC.hashCode());
		result = prime * result + ((emailAddressCC == null) ? 0 : emailAddressCC.hashCode());
		result = prime * result + ((emailAddressFrom == null) ? 0 : emailAddressFrom.hashCode());
		result = prime * result + ((emailAddressTo == null) ? 0 : emailAddressTo.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((templateName == null) ? 0 : templateName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MailDto other = (MailDto) obj;
		if (attachmentFile == null) {
			if (other.attachmentFile != null)
				return false;
		} else if (!attachmentFile.equals(other.attachmentFile))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (emailAddressBCC == null) {
			if (other.emailAddressBCC != null)
				return false;
		} else if (!emailAddressBCC.equals(other.emailAddressBCC))
			return false;
		if (emailAddressCC == null) {
			if (other.emailAddressCC != null)
				return false;
		} else if (!emailAddressCC.equals(other.emailAddressCC))
			return false;
		if (emailAddressFrom == null) {
			if (other.emailAddressFrom != null)
				return false;
		} else if (!emailAddressFrom.equals(other.emailAddressFrom))
			return false;
		if (emailAddressTo == null) {
			if (other.emailAddressTo != null)
				return false;
		} else if (!emailAddressTo.equals(other.emailAddressTo))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (templateName == null) {
			if (other.templateName != null)
				return false;
		} else if (!templateName.equals(other.templateName))
			return false;
		return true;
	}

}
