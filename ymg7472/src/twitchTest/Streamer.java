package twitchTest; 

import org.apache.log4j.Logger;

/**
 * <pre>
 * twitchTest 
 * Streamer.java
 *
 * ���� :
 * </pre>
 * 
 * @since : 2020. 8. 13.
 * @author : ymg74
 * @version : v1.0
 */
public class Streamer {

	private String id;
	private String login;
	private String display_name;
	private String type;
	private String broadcaster_type;
	private String description;
	private String profile_image_url;
	private String offline_image_url;
	private int view_count;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBroadcaster_type() {
		return broadcaster_type;
	}
	public void setBroadcaster_type(String broadcaster_type) {
		this.broadcaster_type = broadcaster_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProfile_image_url() {
		return profile_image_url;
	}
	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}
	public String getOffline_image_url() {
		return offline_image_url;
	}
	public void setOffline_image_url(String offline_image_url) {
		this.offline_image_url = offline_image_url;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	@Override
	public String toString() {
		return "Streamer [id=" + id + ", login=" + login + ", display_name=" + display_name + ", type=" + type
				+ ", broadcaster_type=" + broadcaster_type + ", description=" + description + ", profile_image_url="
				+ profile_image_url + ", offline_image_url=" + offline_image_url + ", view_count=" + view_count + "]";
	}

}
