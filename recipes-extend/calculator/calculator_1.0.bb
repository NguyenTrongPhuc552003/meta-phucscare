DESCRIPTION = "Simple calculator using libmath"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://calculator.c"
S = "${WORKDIR}"

# Build-time dependency on libmath
DEPENDS = "virtual/libmath"

# runtime dependencies (examples)
RDEPENDS:${PN} = "bash coreutils"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} -Wl,--hash-style=gnu calculator.c -lmath -o calculator
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 calculator ${D}${bindir}/
}

