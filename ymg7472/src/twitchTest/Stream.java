package twitchTest; 

import java.util.Arrays;

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
public class Stream {

	private String id;
	private String user_id;
	private String user_name;
	private String game_id;
	private String type;
	private String title;
	private int viewer_count;
	private String started_at;
	private String language;
	private String thumbnail_url;
	private String[] tag_ids;
	@Override
	public String toString() {
		return "Stream [id=" + id + ", user_id=" + user_id + ", user_name=" + user_name + ", game_id=" + game_id
				+ ", type=" + type + ", title=" + title + ", viewer_count=" + viewer_count + ", started_at="
				+ started_at + ", language=" + language + ", thumbnail_url=" + thumbnail_url + ", tag_ids="
				+ Arrays.toString(tag_ids) + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getGame_id() {
		return game_id;
	}
	public void setGame_id(String game_id) {
		this.game_id = game_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getViewer_count() {
		return viewer_count;
	}
	public void setViewer_count(int viewer_count) {
		this.viewer_count = viewer_count;
	}
	public String getStarted_at() {
		return started_at;
	}
	public void setStarted_at(String started_at) {
		this.started_at = started_at;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getThumbnail_url() {
		return thumbnail_url;
	}
	public void setThumbnail_url(String thumbnail_url) {
		this.thumbnail_url = thumbnail_url;
	}
	public String[] getTag_ids() {
		return tag_ids;
	}
	public void setTag_ids(String[] tag_ids) {
		this.tag_ids = tag_ids;
	}


}
