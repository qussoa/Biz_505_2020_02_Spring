package com.biz.shop.persistance.sql;

public class CreateTableSQL {

	// 테이블 생성 부분을 코딩하기 위한 방법
	public static String create_user_table = " CREATE TABLE IF NOT EXISTS tbl_users ("
			+ "	id bigint  PRIMARY KEY AUTO_INCREMENT, " 
			+ "	user_name varchar(50) UNIQUE, "
			+ "	user_pass varchar(125), " 
			+ " enabled boolean default true, "
			+ "	nickname varchar(50), "
			+ "	email varchar(50), "
			+ "	phone varchar(20), " 
			+ "	address varchar(125) " + " ) ";

	public static String create_auth_table = " CREATE TABLE IF NOT EXISTS authorities ("
			+ "	id bigint PRIMARY KEY AUTO_INCREMENT," 
			+ "    username varchar(50)," + "    authority varchar(50)"
			+ " ) ";
	
	public static String create_product_table 
		= "CREATE TABLE IF NOT EXISTS tbl_product "
				+ "( p_code VARCHAR(6) PRIMARY KEY, "
				+	"p_name VARCHAR(125),"
				+	"p_bcode VARCHAR(6),"
				+	"p_dcode VARCHAR(6),"
				+	"p_iprice int,"
				+	"p_oprice int,"
				+	"p_vat boolean default true, "
				+	"p_file VARCHAR(255) )" ;

	public static String create_pro_size_table 
		= "CREATE TABLE IF NOT EXISTS tbl_pro_size( "
		+ " s_seq bigint AUTO_INCREMENT PRIMARY KEY, "
		+ " p_code VARCHAR(6) NOT NULL, " // 상품테이블과 연동
		+ " s_size VARCHAR(20) NOT NULL )"; 			
	
	public static String create_pro_color_table 
		= "CREATE TABLE IF NOT EXISTS tbl_pro_color( "
		+ " c_seq bigint AUTO_INCREMENT PRIMARY KEY, "
		+ " size_seq bigint NOT NULL, " // size table s_seq 와 연동
		+ " c_color VARCHAR(20) NOT NULL,"
		+ " c_qty int default 0 )"; 			
	
	public static String create_fileup_table 
		= "CREATE TABLE IF NOT EXISTS tbl_profile( "
				+ " id bigint AUTO_INCREMENT PRIMARY KEY, "
				+ " file_p_code VARCHAR(6),"
				+ " file_origin_name VARCHAR(255),"
				+ " file_upload_name VARCHAR(255) )";
	
}
