package com.wow.api.repository;

import com.wow.api.config.annotation.SlaveConnection;
import com.wow.api.model.Code;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@SlaveConnection
public interface CoreSlaveRepository {

    List<Code> selectGroupCodeList();

    List<Code> selectDetailCodeList(String groupCode);

    Code selectDetailCode(@Param("groupCode") String groupCode, @Param("detailCode") String detailCode);
}
