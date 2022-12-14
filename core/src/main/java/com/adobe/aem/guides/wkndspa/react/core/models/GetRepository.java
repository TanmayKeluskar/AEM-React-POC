package com.adobe.aem.guides.wkndspa.react.core.models;

import javax.jcr.Repository;
import javax.jcr.SimpleCredentials;

import java.io.FileReader;

import javax.jcr.Node;

import org.apache.jackrabbit.commons.JcrUtils;
import org.json.JSONObject;

import com.google.gson.JsonParser;

public class GetRepository {
       public static void main(String[] args) throws Exception {
              try {
                     // contl + shift + L :
                     // Alt + down arrow
                     // cont + shift + R
                     // /,D ,L
                     // alt+shift+ R , L , M,I

                     // Create a connection to the CQ repository running on local host
                     Repository repository = JcrUtils.getRepository("http://localhost:4502/crx/server");
                     JsonParser parser = new JsonParser();

                     // Create a Session
                     javax.jcr.Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));

                     // Create a node that represents the root node
                     Node root = session.getRootNode();
                     System.out.print("root" + root);
                     // Store content
                     Node adobe = root.getNode("/content/wknd-spa-react/us/en");
                     Node day = adobe.addNode("exchange-lines");
                     day.setProperty("message", "Adobe CQ is part of the Adobe Digital Marketing Suite!");

                     Object obj = parser.parse(new FileReader("D:\\page.json"));
                     JSONObject jsonObject = (JSONObject) obj;
                     String title = (String) jsonObject.get("jcr:title");
                     String resourceType = (String) jsonObject.get("sling:resourceType");
                     //JSONArray subjects = (JSONArray) jsonObject.get("Subjects");
                     day.setProperty("title", title);
                     day.setProperty("resourceType", resourceType);
                     // Store content

                     // Retrieve content
                     Node node = root.getNode("/content/wknd-spa-react/us/en");
                     System.out.println(node.getPath());

                     // Save the session changes and log out
                     session.save();
                     session.logout();
              } catch (Exception e) {
                     e.printStackTrace();
              }
       }

}
