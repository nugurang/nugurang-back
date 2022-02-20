package com.nugurang.oauth2

import org.springframework.security.core.context.SecurityContext
import org.springframework.security.web.context.HttpRequestResponseHolder
import org.springframework.security.web.context.SecurityContextRepository
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class OAuth2RestSecurityContextRepository : SecurityContextRepository {
    override fun loadContext(requestResponseHolder: HttpRequestResponseHolder): SecurityContext {
        // TODO: Implement this
        return null as SecurityContext
    }

    override fun saveContext(context: SecurityContext, request: HttpServletRequest, response: HttpServletResponse) {}
    override fun containsContext(request: HttpServletRequest): Boolean {
        return false
    }
}