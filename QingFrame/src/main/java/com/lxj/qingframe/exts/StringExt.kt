package com.lxj.qingframe.exts

import com.blankj.utilcode.util.EncryptUtils


/**
 * String相关扩展，主要是hash，日期
 */

/** hash **/
fun String.md5() = EncryptUtils.encryptMD5ToString(this)

fun String.sha1() = EncryptUtils.encryptSHA1ToString(this)
fun String.sha256() = EncryptUtils.encryptSHA256ToString(this)
fun String.sha512() = EncryptUtils.encryptSHA512ToString(this)

fun String.md5Hmac(key: String) = EncryptUtils.encryptHmacMD5ToString(this, key)
fun String.sha1Hmac(key: String) = EncryptUtils.encryptHmacSHA1ToString(this, key)

/** encrypt **/
/**
 * key的长度必须为32位
 */
fun String.aesEncrypt(key: String) = String(EncryptUtils.encryptAES2Base64(toByteArray(), key.toByteArray(), "AES/ECB/NoPadding", null))

/**
 * key的长度必须为32位
 */
fun String.aesDecrypt(key: String) = String(EncryptUtils.decryptBase64AES(toByteArray(), key.toByteArray(), "AES/ECB/NoPadding", null))

fun String.desEncrypt(key: String) = String(EncryptUtils.encryptDES(toByteArray(), key.toByteArray(), "DES/ECB/NoPadding", null))
fun String.desDecrypt(key: String) = String(EncryptUtils.decryptDES(toByteArray(), key.toByteArray(), "DES/ECB/NoPadding", null))
fun String.sha256Hmac(key: String) = EncryptUtils.encryptHmacSHA256ToString(this, key)
fun main(args: Array<String>) {
    println("123456".md5())
    println("123456".sha1())
    println("123456".sha256())
    println("123456".sha512())
}