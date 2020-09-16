package myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import myProject.config.kafka.KafkaProcessor;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @Autowired
    StudentRepository studentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSignApproved_Approve(@Payload SignApproved signApproved){

        if(signApproved.isMe()){
            System.out.println("##### listener Approve : " + signApproved.toJson());
            
            Student student = new Student();

            student.setClassName(signApproved.getClassName());
            student.setStatus("SignApproved");
            student.setStudentId(signApproved.getStudentId());
            student.setStudentName(signApproved.getStudentName());

			studentRepository.save(student);
            
        }
    }

}
