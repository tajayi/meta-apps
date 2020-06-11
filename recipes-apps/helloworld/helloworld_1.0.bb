#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

DESCRIPTION = "Example Hello, World application for Yocto build."
SECTION = "apps"
DEPENDS = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI = "file://helloworld.c \
           file://helloworld.h \
           file://Makefile \
        "
S = "${WORKDIR}"
CFLAGS_prepend = "-I ${S}/include"
do_compile() {
        oe_runmake
}
do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${S}/helloworld ${D}${bindir}
}

