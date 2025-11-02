DESCRIPTION = "Simple math library for calculator"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://libmath.c"
S = "${WORKDIR}"

do_compile() {
    ${CC} -c libmath.c -o libmath.o
    ${AR} rcs libmath.a libmath.o
}

do_install() {
    install -d ${D}${libdir}
    install -m 0644 libmath.a ${D}${libdir}/
    install -d ${D}${includedir}
    echo "int add(int a, int b); int sub(int a, int b);" > ${D}${includedir}/libmath.h
}

PROVIDES = "virtual/libmath"

