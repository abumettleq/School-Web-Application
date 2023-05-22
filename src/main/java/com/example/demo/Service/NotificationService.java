package com.example.demo.Service;

import com.example.demo.Entity.Notification;
import com.example.demo.Entity.Student;
import com.example.demo.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    public List<Notification> getNotificationsByStudentId(int student_id)
    {
        List<Notification> notifications = notificationRepository.findBySentTo(student_id);
        return notifications;
    }

    public void insertNewNotification(String senderName, int targetId, LocalTime time, LocalDate date, String content)
    {
        Notification notification = new Notification();
        notification.setContent(content);
        notification.setSentBy(senderName);
        notification.setSentDate(date);
        notification.setSentTime(time);
        notification.setSentTo(targetId);

        notificationRepository.save(notification);
    }
}
