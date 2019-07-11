package jsu.utils;

import java.util.UUID;

/*
 * 随机生成字符串，用于邮箱验证(未完成)
 */
public class MyUUIDUtil
{
	public static String getUUID(){
		
		//随机生成 。去掉- 最大32位
		return UUID.randomUUID().toString().replace("-", "");
	}
}
