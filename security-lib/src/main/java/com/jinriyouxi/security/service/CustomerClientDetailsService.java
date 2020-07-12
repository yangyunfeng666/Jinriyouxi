package com.jinriyouxi.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jinriyouxi.common.constant.Status;
import com.jinriyouxi.security.domain.RClient;
import com.jinriyouxi.security.domain.RPermission;
import com.jinriyouxi.security.mapper.RClientMapper;
import com.jinriyouxi.security.mapper.RPermissionMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;


@Service("customerClientDetailsService")
public class CustomerClientDetailsService implements ClientDetailsService {

    @Resource
    private RClientMapper clientMapper;

    @Resource
    private RPermissionMapper permissionMapper;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        QueryWrapper<RClient> clientQueryWrapper = new QueryWrapper<>();
        clientQueryWrapper.eq("client_key",clientId);
        RClient client = clientMapper.selectOne(clientQueryWrapper);
        if (client != null) {
            List<RPermission> list = permissionMapper.selectByClientId(client.getId());
            client.setPermissionList(list);
        }
        if (client == null) {
            throw new NoSuchClientException("客户端不存在");
        }
        if ((!client.getStatus().equals(Status.ENABLE))) {
            throw new UnknownError("客户端被禁用");
        }
        return client;
    }


}