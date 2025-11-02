SUMMARY = "Rock 5B+ Base Image"
DESCRIPTION = "A minimal base image for Radxa Rock 5B+ development"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Base this image on core-image-minimal
inherit core-image

# Essential packages for Rock 5B+ development
IMAGE_INSTALL:append = " \
    kernel-modules \
    kernel-devsrc \
    python3 \
    python3-numpy \
    i2c-tools \
    libgpiod \
    libgpiod-tools \
    cmake \
    dropbear \
    networkmanager \
"

# Development tools
IMAGE_INSTALL:append = " \
    gdb \
    gdbserver \
    strace \
    htop \
    vim \
"

# Use preferred provider/version
PREFERRED_PROVIDER_virtual/libmath = "libmath"
PREFERRED_VERSION_hello = "0.1"
