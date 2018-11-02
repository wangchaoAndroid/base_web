package com.json.jdbcdemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;


import com.google.common.collect.Maps;
import com.json.jdbcdemo.dao.RoleMapper;
import com.json.jdbcdemo.model.Menu;
import com.json.jdbcdemo.model.Role;
import core.com.eryansky.common.model.TreeNode1;
import core.com.eryansky.common.orm.hibernate.EntityManager;
import core.com.eryansky.common.orm.hibernate.HibernateDao;
import core.com.eryansky.common.orm.hibernate.Parameter;
import core.com.eryansky.common.utils.StringUtils;
import net.sf.json.JSONArray;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;



/** 
* @ClassName: RoleServiceImpl 
* @Description: TODO(角色管理业务类) 
* @author ty 
* @date 2018-3-16 下午02:12:55
*  
*/
@EnableAutoConfiguration
@Service("roleService")
public class RoleServiceImpl extends EntityManager<Role, Integer> {

	@Autowired  private MenuServiceImpl menuService;

	@Autowired  private RoleMapper roleMapper;
	/**
	 * 根据角色名称获取角色
	 */
	public Role getRoleByName(String name) {
        Parameter parameter = new Parameter(name);
        List<Role> list = roleMapper.findRoleByLoginName(name);
		return list.isEmpty() ? null:list.get(0);
	}



//	public void updateRoleMenu(Role role, String ids) {
//		// TODO Auto-generated method stub
//		role.setMenus(new ArrayList<Menu>());
//		//List<Menu> menuList = Lists.newArrayList();
//
//		if (!StringUtils.isBlank(ids)) {
//			JSONArray jArray = JSONArray.fromObject(ids);
//			for(int i = 0; i < jArray.size(); i++){
//				Integer menuId = Integer.valueOf(jArray.getString(i).toString());
//				Menu menu = menuService.getMenuById(menuId);
//				role.getMenus().add(menu);
//			}
//		}
////	   merge(role);
//	}

	/**    
	 * <p>Description:保存不覆盖 </p>   
	 * @param role   
	 * @see 
	 */ 

	public  void saveEntity(Role role) {
		 if(role.getId()!=null) {
			  Role tempRole=roleMapper.findRoleById(role.getId());
			  tempRole.setCode(role.getCode());
			  tempRole.setName(role.getName());
			  tempRole.setRemark(role.getRemark());
			  tempRole.setStatus(role.getStatus());
			  role.setMenus(tempRole.getMenus());
		 } else {
//			 save(role);
		 }
		
	}
//   @Transactional
//	public List<TreeNode1> getMenuRole(Integer id) {
//		// TODO Auto-generated method stub
//		List<TreeNode1> treeNodes = menuService.getMenuTree();
//    	List<Integer> ids = getById(id).getMenuIds();
//    	for(TreeNode1 node1 : treeNodes){
//    		if(ids.contains(Integer.valueOf(node1.getId()))){
//    			Map<String, Object> state = Maps.newHashMap();
//				state.put("checked", true);
//				node1.setState(state);
//    		}
//    		for(TreeNode1 children : node1.getNodes()){
//    			if(ids.contains(Integer.valueOf(children.getId()))){
//					Map<String, Object> state = Maps.newHashMap();
//					state.put("checked", true);
//					children.setState(state);
//    				for(TreeNode1 children1 : children.getNodes()){
//    					if(ids.contains(Integer.valueOf(children1.getId()))){
//    						children1.setState(state);
//    					}
//    				}
//    			}
//    		}
//    	}
//    	return treeNodes;
//}

	private Role getById(Integer id) {
		return roleMapper.findRoleById(id);
	}
}
