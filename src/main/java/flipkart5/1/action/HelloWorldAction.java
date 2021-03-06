package flipkart5.1.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.bristleback.server.bristle.api.action.DefaultAction;
import pl.bristleback.server.bristle.api.annotations.Action;
import pl.bristleback.server.bristle.api.annotations.ActionClass;
import pl.bristleback.server.bristle.api.annotations.Bind;
import pl.bristleback.server.bristle.engine.base.users.DefaultUser;

@ActionClass(name = "HelloWorld")
@Controller
public class HelloWorldAction implements DefaultAction<DefaultUser, String> {

  @Autowired
  private SampleClientAction sampleClientAction;

  @Action
  public String executeDefault(DefaultUser defaultUser, @Bind(required = true) String text) {
    return new StringBuilder(text).reverse().toString();
  }

  @Action
  public String duplicateText(@Bind(required = true) String text) {
    return new StringBuilder(text).append(text).toString();
  }

  @Action
  public void sayHelloToAll() {
    sampleClientAction.sayHello("Hello everyone!");
  }
}
