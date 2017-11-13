package com.hascode.tutorial;

import com.github.jsonldjava.core.JsonLdError;
import com.github.jsonldjava.core.JsonLdOptions;
import com.github.jsonldjava.core.JsonLdProcessor;
import com.github.jsonldjava.utils.JsonUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException, JsonLdError {
    InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("person.json");

    Object jsonObject = JsonUtils.fromInputStream(inputStream);

    Map context = new HashMap();
    JsonLdOptions options = new JsonLdOptions();

    Object compact = JsonLdProcessor.compact(jsonObject, context, options);
    System.out.printf("--------------\njson-ld compact: %s\n", JsonUtils.toPrettyString(compact));

    Object rdf = JsonLdProcessor.toRDF(jsonObject);
    System.out.printf("--------------\njson-ld to RDF: %s\n", JsonUtils.toPrettyString(rdf));
  }
}
