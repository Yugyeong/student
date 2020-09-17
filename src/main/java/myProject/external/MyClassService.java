
package myProject.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="myClassManagement", url="${api.url.myClassManagement}")
public interface MyClassService {
    
    @RequestMapping(method=RequestMethod.POST, path="/myClasses/sc")
    public void studentChange(@RequestBody MyClass myClass);
    
    //@RequestMapping(method= RequestMethod.GET, path="/myClasses/ssign")
    //public void studentSign(@RequestBody MyClass myClass);
}