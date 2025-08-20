package com.petcare.commons.model.dto;

import com.petcare.commons.model.enums.NotificationChannel;
import com.petcare.commons.model.enums.PreferredLanguage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPreferencesDTO {
    private PreferredLanguage preferredLanguage;
    private boolean receiveAppointmentReminders;
    private boolean receiveVaccinationReminders;
    private boolean receiveMarketingEmails;
    private boolean receiveOrderUpdates;
    private NotificationChannel preferredChannel;

}
