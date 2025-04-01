import jenkins.model.*
import hudson.model.*

// Get Jenkins instance
def jenkins = Jenkins.instance

// Define job name
def jobName = 'ashok_Job'

// Check if job already exists
if (jenkins.getItem(jobName)) {
    println "Job '${jobName}' already exists!"
} else {
    // Create a new Freestyle Job
    def job = new FreeStyleProject(jenkins, jobName)
    
    // Add a simple shell command as a build step
    job.buildersList.add(new hudson.tasks.Shell("echo 'Hello, Jenkins!'"))

    // Save the job
    jenkins.add(job, jobName)
    job.save()
    println "Job '${jobName}' created successfully!"
}
