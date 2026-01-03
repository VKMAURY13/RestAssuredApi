package api.endpoints;

public class Routes {
	
	public static String base_url = "https://fakestoreapi.com";
	
	
	//UserModule
	public static String user_post_url = base_url+"/users";
	public static String user_get_url = base_url+"/users/{id}";
	public static String user_update_url = base_url+"/users/{id}";
	public static String user_delete_url = base_url+"/users/{id}";
	
	
	//Auth Module
	public static String auth_url = base_url+"/auth/login";
	
	//Cart Module
	public static String cart_post_url = base_url+"/carts";
	public static String cart_get_url = base_url+"/carts/{id}";
	public static String cart_update_url = base_url+"/carts/{id}";
	public static String cart_delete_url = base_url+"/carts/{id}";
	
	//Product Module
		public static String product_post_url = base_url+"/products";
		public static String product_get_url = base_url+"/products/{id}";
		public static String product_update_url = base_url+"/products/{id}";
		public static String product_delete_url = base_url+"/products/{id}";
	
	

}
