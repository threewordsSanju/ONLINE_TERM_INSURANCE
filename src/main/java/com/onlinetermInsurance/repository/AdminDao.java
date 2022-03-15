/*
 * package com.onlinetermInsurance.repository;
 * 
 * import java.util.List;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.onlinetermInsurance.entity.Admin; import
 * com.onlinetermInsurance.entity.Policy; import
 * com.onlinetermInsurance.entity.User;
 * 
 * 
 * @Repository public interface AdminDao extends JpaRepository<Admin, Integer> {
 * 
 * @Query("Select U from User U where U.userId=?1 order by U.useId") List<User>
 * findByUserId(int id);
 * 
 * List<User> getUserById(String id);
 * 
 * List<User> deleteUsers (List l);
 * 
 * List<Policy> getPolicies();
 * 
 * }
 */