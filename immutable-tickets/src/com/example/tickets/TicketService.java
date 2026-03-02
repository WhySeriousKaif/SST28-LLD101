package com.example.tickets;

/**
 * Service layer that creates and updates tickets.
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // No scattered validation here anymore!
        return IncidentTicket.builder()
                .id(id)
                .reporterEmail(reporterEmail)
                .title(title)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .addTag("NEW")
                .build();
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {
        // Returns a NEW instance
        return t.toBuilder()
                .priority("CRITICAL")
                .addTag("ESCALATED")
                .build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        // Returns a NEW instance with validation handled by builder
        return t.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }
}
