/**   
 *       
 * 名称：UserController   
 * 描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月9日 下午8:19:41 
 * @version       
 */ 

package cn.com.taiji.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.taiji.dto.UserDTO;
import cn.com.taiji.service.UserService;

/**        
 * 类名称：UserController   
 * 类描述：   
 * 创建人：Administrator   
 * 创建时间：2017年12月9日 下午8:19:41 
 * @version      
 */
@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
//	@Autowired
//	RoleService roleService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	/**
	 * 查询所有用户
	 */
//	@RequestMapping(value="/getuserList",method=RequestMethod.POST)
//	@ResponseBody
//	public String allUser() {
//		//分页
//		String json = "{\"page\":1,\"pageSize\":8,\"filter\":{\"filters\":[{\"field\":\"loginName\",\"value\":\"sue\"},{\"field\":\"userName\",\"value\":\"sd\"}],\"logic\":\"and\"},\"sort\":[{\"field\":\"loginName\",\"dir\":\"asc\"},{\"field\":\"email\",\"dir\":\"asc\"}]}";
//		Map searchParameters = new HashMap();
//		try {
//			searchParameters = objectMapper.readValue(json,new TypeReference<Map>() {});
//			Map page = userService.getPage(searchParameters, null);
//			System.out.println("page=="+page);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		List<UserDTO> list = userService.allUser();
//		model.addAttribute("list", list);
//		Map page = userService.getPage(1, 2, null, null);
//		return "user-list";
//	}

	
	@GetMapping("/touserlist")
	public String userList() {
		return "user-list";
	}
	
	@PostMapping("/userlist")
	@ResponseBody
	public Map getUserList(@RequestParam(value="limit",defaultValue="0")int limit, @RequestParam(value="offset",defaultValue="10")int offset) {
		Map pageList = new HashMap<>();
		pageList = userService.getPage(limit-1, offset, null,null);
		//System.out.println(pageList);
		return pageList;
	}
	
	
	@PostMapping("addUser")
	public String saveUser(UserDTO userDTO) {
	
		userService.addUser(userDTO);
		return "user-list";
	}
	
	
	@GetMapping("/delete")
	public String saveUser(String id) {
		userService.deleteUser(id);
		return "user-list";
	}
	
	@PostMapping("update")
	@ResponseBody
	public UserDTO update(String id) {
		UserDTO user = userService.findUserById(id);
		return user;
	}
	
	
	@PostMapping("updateUser")
	public String updateUser(UserDTO userDTO) {
		System.out.println(userDTO);
		//userService.updateUser(userDTO);
		return "user-list";
	}
//	/**
//	 * 跳到新增页面-- 新增用户
//	 */
//	@RequestMapping("/toAddUser")
//	public String toAddUser() {
//		return "addUser";
//	}
//	@RequestMapping("/addUser")
//	public String addUser() {
//		UserDTO userDTO = new UserDTO();	
//		
//		//userDTO.setId("5");
//		
//		userDTO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
//		userDTO.setUserNum("6");
//		userDTO.setUserName("sd");
//		
//		System.out.println("Calendar.getInstance()==="+Calendar.getInstance());
//		
////	
////		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////		String username = userDetails.getUsername();
////		//操作者
////		userDTO.setManager( username );
//		
//		UserDTO addUser = userService.addUser(userDTO);
//		System.out.println("addUser==="+addUser);
//		//权限
//		userService.getRoles(userDTO);
//		return "index";
//	}
//	
//	
//	/**
//	 * 修改用户信息
//	 */
//	//跳转到用户界面
//	@RequestMapping("toUpdateUser")
//	public String toUpdateUser(@RequestParam("id") String id,Model model) {
//		//获取用户信息
//		UserDTO userDTO = userService.findUserById(id);
//		model.addAttribute("userDTO", userDTO);
//		return "updateUser";
//	}
//	
//	
//	@RequestMapping("updateUser")
//	public String updateUser(@RequestParam("userDTO") UserDTO userDTO) {
//		userService.updateUser(userDTO);
//		
//		return "index";
//	}
//	
//	
//	
//	/**
//	 * 删除用户
//	 */
//	@RequestMapping("deleteUser")
//	public String deleteUser(@RequestParam("id") String id) {
//		userService.deleteUser(id);
//		//假删除
//		List<UserDTO> list = userService.allUser();
//		boolean remove = list.remove( userService.findUserById(id) );
//		System.out.println( remove );
//		
//		return "index";
//	}
//	
//	
//	/**
//	 * 姓名查询
//	 */
//	@RequestMapping("search")
//	public String search() {
//		//权限
//		//userService.getRoles();
//		
//		List<UserDTO> names = userService.findUserByUsername("2");
//		names.forEach(System.out::println);
//		return "index";
//	}
	
	
}
