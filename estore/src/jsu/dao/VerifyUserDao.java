package jsu.dao;

/*
 * 验证用户
 */
public interface VerifyUserDao {
	//验证用户的id是否已经存在
	Long verifyUserFindId(String userId);

}
