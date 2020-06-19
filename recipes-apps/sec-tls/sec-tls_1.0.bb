DESCRIPTION = "sec-tls application"
SECTION = "apps"
DEPENDS = ""
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRC_URI = "git://github.com/eembc/securemark-tls.git;protocol=https"

S = "${WORKDIR}/git/examples/selfhosted"
SRCREV = "${AUTOREV}"

EXTRA_OECMAKE=""

inherit pkgconfig cmake

do_configure() {
        cmake ${S}
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ./sec-tls ${D}${bindir}
}
