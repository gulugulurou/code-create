package com.wanan.yuaicodemother.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.wanan.yuaicodemother.model.dto.app.AppQueryRequest;
import com.wanan.yuaicodemother.model.dto.app.AppVO;
import com.wanan.yuaicodemother.model.entity.App;
import com.wanan.yuaicodemother.model.entity.User;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author coin
 */
public interface AppService extends IService<App> {

    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    AppVO getAppVO(App app);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    List<AppVO> getAppVOList(List<App> appList);
}
