/**
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 * <p>
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 * <p>
 * or (per the licensee's choosing)
 * <p>
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package com.hzed.qmqb.admin.infrastructure.config.logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import com.hzed.qmqb.admin.infrastructure.utils.MdcUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 不拦截moduleName的日志
 *
 * @author guichang
 */
@Data
public class MyModuleNameNotFilter extends Filter<ILoggingEvent> {
    /**
     * 不需拦截的moduleName
     */
    private String moduleName;

    @Override
    public FilterReply decide(ILoggingEvent event) {
        String moduleNameLog = event.getMDCPropertyMap().get(MdcUtil.MODULENAME);
        boolean isModuleName = StringUtils.isNotBlank(moduleNameLog) && moduleNameLog.indexOf(moduleName) > -1;
        if (isModuleName) {
            return FilterReply.DENY;
        } else {
            return FilterReply.ACCEPT;
        }
    }

}
