package com.shoukeplus.jFinal.common.model;

import com.jfinal.plugin.activerecord.Page;
import com.shoukeplus.jFinal.common.model.base.BaseDict;
import com.shoukeplus.jFinal.common.utils.StrUtil;
import org.apache.commons.collections.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Dict extends BaseDict<Dict> {
	public static final Dict dao = new Dict();
	public Page<Dict> page(int pageNumber, int pageSize, String value) {
		StringBuffer condition = new StringBuffer();
		if (!StrUtil.isBlank(value)) condition.append(" and d.value like \"%" + value + "%\" ");
		return super.paginate(pageNumber, pageSize, "select d.* ", "from sk_dict d where 1 = 1 " + condition + " order by d.type desc,d.sort asc");
	}

	public List<Dict> findByNameLike(String value) {
		return super.find("select * from sk_dict where value like ?", "%" + value + "%");
	}

	public Dict findByName(String value) {
		return super.findFirst("select * from sk_dict where value = ?", value);
	}


	public List<Dict> findAll() {
		return super.find("select * from sk_dict order by id desc");
	}

	public Map<String,Object> getMap4Type(String type) {
		List<Dict> dicts = super.find("select * from sk_dict where type= ? order by sort asc", type);
		if (CollectionUtils.isEmpty(dicts)) {
			return null;
		}
		Map<String, Object> map = new HashMap<>(dicts.size());
		for (Dict dict : dicts) {
			map.put(dict.getKey(), dict.getValue());
		}
		return map;
	}
	public List<Dict> getList4Type(String type) {
		List<Dict> dicts = super.find("select * from sk_dict where type= ? order by sort asc", type);
		if (CollectionUtils.isEmpty(dicts)) {
			return null;
		}
		return dicts;
	}
}
