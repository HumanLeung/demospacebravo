package com.example.demospacebravo.utils;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
public class JsonToPoJo {

    public void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory,
                                       String packageName,String javaClassName) throws IOException {
        JCodeModel jcodeModel = new JCodeModel();

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() {
                return true;
            }

            @Override
            public SourceType getSourceType() {
                return super.getSourceType();
            }
        };

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config,
                new Jackson2Annotator(config), new SchemaStore()),
                new SchemaGenerator());
        mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);
        jcodeModel.build(outputJavaClassDirectory);
    }

}
