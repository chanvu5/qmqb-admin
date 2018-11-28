package com.hzed.qmqb.admin.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileModel {
	private String fileName;
	private String filePath;
}
