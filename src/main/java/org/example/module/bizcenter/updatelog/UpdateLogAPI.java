package org.example.module.bizcenter.updatelog;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface UpdateLogAPI {

    List<JSONObject> selectRunTaskModifyInfo(Long linkId);

}
