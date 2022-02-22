package com.nugurang.http

import org.springframework.util.StreamUtils
import java.io.*
import javax.servlet.ReadListener
import javax.servlet.ServletInputStream
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper

class MultiReadableHttpServletRequest(request: HttpServletRequest) : HttpServletRequestWrapper(request) {
    private val cachedBody: ByteArray

    init {
        val requestInputStream: InputStream = request.inputStream
        cachedBody = StreamUtils.copyToByteArray(requestInputStream)
    }

    @Throws(IOException::class)
    override fun getInputStream(): ServletInputStream {
        return MultiReadableServletInputStream(cachedBody)
    }

    @Throws(IOException::class)
    override fun getReader(): BufferedReader {
        // Create a reader from cachedContent
        // and return it
        val byteArrayInputStream = ByteArrayInputStream(cachedBody)
        return BufferedReader(InputStreamReader(byteArrayInputStream))
    }

    private inner class MultiReadableServletInputStream(cachedBody: ByteArray?) : ServletInputStream() {
        private val cachedBodyInputStream: InputStream

        init {
            cachedBodyInputStream = ByteArrayInputStream(cachedBody)
        }

        override fun isFinished(): Boolean {
            // TODO: Considering removing this try-catch clause
            try {
                return cachedBodyInputStream.available() == 0
            } catch (e: IOException) {
                e.printStackTrace()
            }
            return false
        }

        override fun isReady(): Boolean {
            return true
        }

        override fun setReadListener(readListener: ReadListener) {
            throw UnsupportedOperationException()
        }

        @Throws(IOException::class)
        override fun read(): Int {
            return cachedBodyInputStream.read()
        }
    }
}