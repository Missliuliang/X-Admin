package com.leaf.xadmin.mapper.auth;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.leaf.xadmin.entity.auth.Permission;
import com.leaf.xadmin.entity.auth.Resource;
import com.leaf.xadmin.entity.auth.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author leaf
 * <p>date: </p>
 */
@Mapper
@Repository
public interface ResourceMapper extends BaseMapper<Resource> {

    /**
     * 批量添加资源列表
     *
     * @param resourceList
     */
    void insertBatch(List<Resource> resourceList);

    /**
     * 批量更新资源列表
     *
     * @param resourceList
     */
    void updateBatch(List<Resource> resourceList);

    /**
     * 删除资源角色
     *
     * @param resourceId
     * @param roleId
     */
    void deleteResourceRole(@Param("resourceId") Long resourceId, @Param("roleId") Long roleId);

    /**
     * 添加资源角色
     *
     * @param resourceId
     * @param roleId
     */
    void insertResourceRole(@Param("resourceId")Long resourceId, @Param("roleId")Long roleId);

    /**
     * 删除资源权限
     *
     * @param resourceId
     * @param permissionId
     */
    void deleteResourcePermission(@Param("resourceId")Long resourceId, @Param("permissionId") Long permissionId);

    /**
     * 添加资源权限
     *
     * @param resourceId
     * @param permissionId
     */
    void insertResourcePermission(@Param("resourceId")Long resourceId, @Param("permissionId") Long permissionId);

    /**
     * 查询资源角色列表
     *
     * @param resourceId
     * @return
     */
    List<Role> selectResourceRoles(Long resourceId);

    /**
     * 查询资源权限列表
     *
     * @param resourceId
     * @return
     */
    List<Permission> selectResourcePermissions(Long resourceId);

    /**
     * 根据路径查询资源角色列表
     *
     * @param path
     * @return
     */
    Set<Role> selectResourceRolesByPath(String path);

    /**
     * 根据路径查询资源权限列表
     *
     * @param path
     * @return
     */
    Set<Permission> selectResourcePermissionsByPath(String path);

    /**
     * 删除资源权限依赖
     *
     * @param id
     * @return
     */
    Integer deleteResourcePermDeps(Serializable id);

    /**
     * 删除资源角色依赖
     *
     * @param id
     * @return
     */
    Integer deleteResourceRoleDeps(Serializable id);
}
