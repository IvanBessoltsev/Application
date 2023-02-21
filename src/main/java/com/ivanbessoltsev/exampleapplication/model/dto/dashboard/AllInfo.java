package com.ivanbessoltsev.exampleapplication.model.dto.dashboard;

import com.ivanbessoltsev.exampleapplication.projection.NameAndCount;
import lombok.Data;

import java.util.List;

@Data
public class AllInfo {
  List<NameAndCount> listInfo;
}
