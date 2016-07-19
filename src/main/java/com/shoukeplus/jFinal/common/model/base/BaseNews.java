package com.shoukeplus.jFinal.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseNews<M extends BaseNews<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setDictId(java.lang.Integer dictId) {
		set("dictId", dictId);
	}

	public java.lang.Integer getDictId() {
		return get("dictId");
	}

	public void setTarget(java.lang.String target) {
		set("target", target);
	}

	public java.lang.String getTarget() {
		return get("target");
	}

	public void setIsExternalHref(java.lang.Integer isExternalHref) {
		set("isExternalHref", isExternalHref);
	}

	public java.lang.Integer getIsExternalHref() {
		return get("isExternalHref");
	}

	public void setExternalHref(java.lang.String externalHref) {
		set("externalHref", externalHref);
	}

	public java.lang.String getExternalHref() {
		return get("externalHref");
	}

	public void setTitle(java.lang.String title) {
		set("title", title);
	}

	public java.lang.String getTitle() {
		return get("title");
	}

	public void setIntroduction(java.lang.String introduction) {
		set("introduction", introduction);
	}

	public java.lang.String getIntroduction() {
		return get("introduction");
	}

	public void setContent(java.lang.String content) {
		set("content", content);
	}

	public java.lang.String getContent() {
		return get("content");
	}

	public void setView(java.lang.Integer view) {
		set("view", view);
	}

	public java.lang.Integer getView() {
		return get("view");
	}

	public void setAuthor(java.lang.String author) {
		set("author", author);
	}

	public java.lang.String getAuthor() {
		return get("author");
	}

	public void setSource(java.lang.String source) {
		set("source", source);
	}

	public java.lang.String getSource() {
		return get("source");
	}

	public void setSort(java.lang.Integer sort) {
		set("sort", sort);
	}

	public java.lang.Integer getSort() {
		return get("sort");
	}

	public void setIsdelete(java.lang.Integer isdelete) {
		set("isdelete", isdelete);
	}

	public java.lang.Integer getIsdelete() {
		return get("isdelete");
	}

	public void setCreatedTime(java.util.Date createdTime) {
		set("createdTime", createdTime);
	}

	public java.util.Date getCreatedTime() {
		return get("createdTime");
	}

	public void setUpdatedTime(java.util.Date updatedTime) {
		set("updatedTime", updatedTime);
	}

	public java.util.Date getUpdatedTime() {
		return get("updatedTime");
	}

}
