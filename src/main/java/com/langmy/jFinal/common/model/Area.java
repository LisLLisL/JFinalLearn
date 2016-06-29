package com.langmy.jFinal.common.model;

import cn.dreampie.tree.TreeNode;
import com.google.common.collect.Lists;
import com.langmy.jFinal.common.model.base.BaseArea;

import java.util.List;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Area extends BaseArea<Area> implements TreeNode<Area> {
	private List<Area> children = Lists.newArrayList();

	public static final Area dao = new Area();

	@Override
	public long getId() {
		return super.getAreaId().longValue();
	}

	@Override
	public long getParentId() {
		return super.getPid();
	}

	@Override
	public List<Area> getChildren() {
		return super.get("children");
	}

	@Override
	public void setChildren(List<Area> children) {
		super.put("children",children);
	}
}
