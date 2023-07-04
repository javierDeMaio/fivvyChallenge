package FivvyChallenge.Backend.Entity;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "disclaimer")
public class Disclaimer {
	@Id
	private String id;
	private String name;
	private String text;
	private Long version;
	private Date createAt;
	private Date updateAt;

	public Disclaimer(String id, String name, String text, Long version, Date createAt, Date updateAt) {
		this.id = id;
		this.name = name;
		this.text = text;
		this.version = version;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
}
