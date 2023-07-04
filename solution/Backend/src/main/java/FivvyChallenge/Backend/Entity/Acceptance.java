package FivvyChallenge.Backend.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "acceptance")
public class Acceptance {
	@Id
	private String disclaimerId;
	private Long userId;
	private Date createAt;

	public Acceptance(String disclaimerId, Long userId, Date createAt) {
		this.disclaimerId = disclaimerId;
		this.userId = userId;
		this.createAt = createAt;
	}

	public String getDisclaimerId() {
		return disclaimerId;
	}

	public void setDisclaimerId(String disclaimerId) {
		this.disclaimerId = disclaimerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}