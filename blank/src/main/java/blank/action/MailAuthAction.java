package blank.action;

import org.seasar.struts.annotation.Execute;

import blank.annotation.PublicService;

public class MailAuthAction {

    @PublicService
    @Execute(validator=false)
    public String index() {
        return "index.jsp";
    }
}
