package com.androiddevelopers.freelanceapp.model.jobpost

import com.androiddevelopers.freelanceapp.util.JobStatus

class FreelancerJobPost: BaseJobPost {
    var freelancerId: String? = null // İlanı oluşturan freelancer'ın kimliği
    var rating: Double? = null // İşveren tarafından işin başarı derecesini belirtmek için

    constructor() : super()

    constructor(
        postId: String?,
        title: String?,
        description: String?,
        images: List<String>?,
        skillsRequired: List<String>?,
        budget: Double?,
        deadline: String?,
        location: String?,
        datePosted: String?,
        applicants: List<String>?,
        status: JobStatus?,
        additionalDetails: String?,
        viewCount: Int?,
        isUrgent: Boolean?,
        freelancerId: String?,
        rating: Double?
    ) : super(
        postId,
        title,
        description,
        images,
        skillsRequired,
        budget,
        deadline,
        location,
        datePosted,
        applicants,
        status,
        additionalDetails,
        viewCount,
        isUrgent
    ) {
        this.freelancerId = freelancerId
        this.rating = rating
    }
}
