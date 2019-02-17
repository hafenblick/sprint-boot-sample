package hello;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class JobController 
{

    private static final String template = "JobDetails ";
    private final AtomicLong counter = new AtomicLong();
    private HashMap<Long, Job> m_JobMap;
    
    public JobController()
    {
        m_JobMap = new HashMap<Long, Job>();
        for (long i=0; i<100; i++)
        {
            Long id = counter.incrementAndGet();
            String sDetails = template + i;
            m_JobMap.put(id, new Job(id, sDetails) );
        }
    }

    @GetMapping("/jobs")
    public List<Job> getJobs() 
    {
        return new ArrayList<Job>(m_JobMap.values());
    }
    
    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id) 
    {
        return m_JobMap.get(id);
    }
    
    
}