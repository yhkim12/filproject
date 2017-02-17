package com.filproject.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {

	List<CodeVO> selectAllCodeList() throws Exception;

}
