package com.github.vkuzel.gradle_multi_project_development_template.framework.module1;

import com.github.vkuzel.gradle_multi_project_development_template.framework.core_module.CoreModuleApplication;
import com.github.vkuzel.gradle_multi_project_development_template.framework.core_module.CoreModuleSpeaker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CoreModuleApplication.class)
public class Module1Tests {

    @Autowired
    CoreModuleSpeaker coreModuleSpeaker;

    @Autowired
    Module1Speaker module1Speaker;

    @Test
    public void testAvailableSpeakers() {
        Assert.assertEquals(CoreModuleSpeaker.class.getName(), coreModuleSpeaker.getName());
        Assert.assertEquals(Module1Speaker.class.getName(), module1Speaker.getName());
    }
}