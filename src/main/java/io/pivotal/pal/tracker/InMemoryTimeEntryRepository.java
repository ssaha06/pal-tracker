package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Map<Long, TimeEntry> timeEntryMap = new HashMap<Long, TimeEntry>();


    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        Long id  = Long.valueOf(this.timeEntryMap.values().size()) + 1L;
        timeEntry.setId(id);
        this.timeEntryMap.put(id, timeEntry);
        return timeEntry;

//        return new TimeEntry(1L, any.getProjectId(), any.getUserId(), any.getDate(), any.getHours());
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return this.timeEntryMap.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {

       return new ArrayList<TimeEntry>(this.timeEntryMap.values());

    }

    @Override
    public TimeEntry update(long eq, TimeEntry any) {
        any.setId(eq);
        this.timeEntryMap.put(eq, any);
        return any;
    }

    @Override
    public long delete(long timeEntryId) {
        this.timeEntryMap.remove(timeEntryId);
        return timeEntryId;
    }

}


